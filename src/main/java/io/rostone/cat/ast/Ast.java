package io.rostone.cat.ast;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class Ast {
    public ArrayList<Exp> exps = new ArrayList<>();
    // DONE by Claude to not lose time on dumper dot ==========
    private transient final IdentityHashMap<Object, Integer> visited = new IdentityHashMap<>();
    private transient int nextId = 0;

    public Ast(){
    }

    public static String toJson(Object root) {
        return new Ast().dump(root, 0);
    }
 
    private String dump(Object obj, int indent) {
        if (obj == null) {
            return "null";
        }
 

        if (obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        }
        if (obj instanceof String || obj instanceof Character || obj instanceof Enum<?>) {
            return quote(obj.toString());
        }
 
        if (obj instanceof Collection<?> col) {
            if (col.isEmpty()) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder("[\n");
            String pad = "  ".repeat(indent + 1);
            boolean first = true;
            for (Object item : col) {
                if (!first) {
                    sb.append(",\n");
                }
                first = false;
                sb.append(pad).append(dump(item, indent + 1));
            }
            sb.append("\n").append("  ".repeat(indent)).append("]");
            return sb.toString();
        }
 
        if (obj instanceof Map<?, ?> map) {
            if (map.isEmpty()) {
                return "{}";
            }
            StringBuilder sb = new StringBuilder("{\n");
            String pad = "  ".repeat(indent + 1);
            boolean first = true;
            for (Map.Entry<?, ?> e : map.entrySet()) {
                if (!first) {
                    sb.append(",\n");
                }
                first = false;
                sb.append(pad).append(quote(String.valueOf(e.getKey()))).append(": ")
                  .append(dump(e.getValue(), indent + 1));
            }
            sb.append("\n").append("  ".repeat(indent)).append("}");
            return sb.toString();
        }
 
        if (isJdkClass(obj.getClass())) {
            return quote(obj.toString());
        }
 
        Integer seen = visited.get(obj);
        if (seen != null) {
            return "{ \"_ref\": " + seen + " }";
        }
        int id = nextId++;
        visited.put(obj, id);
 
        StringBuilder sb = new StringBuilder();
        String pad = "  ".repeat(indent + 1);
        sb.append("{\n");
        sb.append(pad).append("\"_id\": ").append(id).append(",\n");
        sb.append(pad).append("\"_type\": ").append(quote(obj.getClass().getSimpleName()));
 
        for (Field f : getFields(obj.getClass())) {
            int mods = f.getModifiers();
            if (Modifier.isStatic(mods) || Modifier.isTransient(mods)) {
                continue;
            }
            f.setAccessible(true);
            Object value;
            try {
                value = f.get(obj);
            } catch (IllegalAccessException | RuntimeException e) {
                continue;
            }
            sb.append(",\n")
              .append(pad).append(quote(f.getName())).append(": ")
              .append(dump(value, indent + 1));
        }
 
        sb.append("\n").append("  ".repeat(indent)).append("}");
        return sb.toString();
    }
 
    private static boolean isJdkClass(Class<?> c) {
        String p = c.getPackageName();
        return p.startsWith("java.") || p.startsWith("javax.")
            || p.startsWith("jdk.") || p.startsWith("sun.");
    }



    private static List<Field> getFields(Class<?> c) {
        List<Field> out = new ArrayList<>();
        while (c != null && c != Object.class) {
            out.addAll(Arrays.asList(c.getDeclaredFields()));
            c = c.getSuperclass();
        }
        return out;
    }

    private static String quote(String s) {
        return "\"" + s.replace("\\", "\\\\")
                       .replace("\"", "\\\"")
                       .replace("\n", "\\n")
                       .replace("\r", "\\r")
                       .replace("\t", "\\t") + "\"";
    }

    private static final String HTML_TEMPLATE = """
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AST Graph — cat</title>
<style>
  :root{
    --bg:#0f141b; --panel:#151c26; --panel-2:#1b2531; --line:#26313f;
    --ink:#e6edf5; --muted:#8496ab; --accent:#e8a13a; --danger:#e05a5a;
    --mono:"SF Mono",ui-monospace,"JetBrains Mono","Cascadia Code",Menlo,Consolas,monospace;
    --sans:ui-sans-serif,system-ui,-apple-system,"Segoe UI",Roboto,sans-serif;
  }
  *{box-sizing:border-box}
  html,body{height:100%;margin:0}
  body{background:var(--bg);color:var(--ink);font-family:var(--sans);display:flex;flex-direction:column;overflow:hidden;}
  header{display:flex;align-items:center;gap:14px;padding:10px 16px;border-bottom:1px solid var(--line);background:var(--panel);flex:none;}
  header .brand{display:flex;align-items:baseline;gap:9px;font-weight:600;letter-spacing:.2px}
  header .brand .dot{color:var(--accent)}
  header .brand small{color:var(--muted);font-weight:400;font-family:var(--mono);font-size:12px}
  header .spacer{flex:1}
  button{font-family:var(--sans);font-size:13px;color:var(--ink);background:var(--panel-2);border:1px solid var(--line);border-radius:7px;padding:7px 12px;cursor:pointer;transition:border-color .15s,background .15s;}
  button:hover{border-color:#3a4a5e}
  button.primary{background:var(--accent);color:#1a1206;border-color:transparent;font-weight:600}
  button.primary:hover{background:#f0ac47}
  main{flex:1;display:flex;min-height:0}
  .editor{width:340px;flex:none;display:flex;flex-direction:column;border-right:1px solid var(--line);background:var(--panel);transition:width .18s,margin .18s;}
  .editor.collapsed{width:0;margin-left:-1px;overflow:hidden}
  .editor .lbl{padding:9px 14px 6px;font-size:11px;text-transform:uppercase;letter-spacing:.9px;color:var(--muted)}
  textarea{flex:1;resize:none;border:0;outline:none;background:transparent;color:var(--ink);font-family:var(--mono);font-size:12.5px;line-height:1.55;padding:2px 14px 14px;tab-size:2;}
  .stage{flex:1;position:relative;overflow:hidden;background:radial-gradient(circle at 1px 1px,#1c2531 1px,transparent 0) 0 0/22px 22px,var(--bg)}
  .stage.grab{cursor:grab}
  .stage.grabbing{cursor:grabbing}
  #viewport{position:absolute;top:0;left:0;transform-origin:0 0;will-change:transform}
  #viewport svg{display:block}
  .hud{position:absolute;left:12px;bottom:12px;display:flex;gap:6px;align-items:center;background:rgba(21,28,38,.85);backdrop-filter:blur(6px);border:1px solid var(--line);border-radius:9px;padding:5px;font-family:var(--mono);font-size:12px;}
  .hud button{padding:4px 9px}
  .hud .z{min-width:52px;text-align:center;color:var(--muted)}
  .err{position:absolute;left:50%;top:20px;transform:translateX(-50%);max-width:70%;background:#2a1616;border:1px solid var(--danger);color:#f3b6b6;padding:10px 14px;border-radius:8px;font-family:var(--mono);font-size:12.5px;white-space:pre-wrap;display:none;z-index:5;}
</style>
</head>
<body>
<header>
  <div class="brand">cat<span class="dot">·</span>ast <small>graph viewer</small></div>
  <div class="spacer"></div>
  <button id="toggleEditor">JSON</button>
  <button id="fit">Ajuster</button>
  <button id="dl">SVG</button>
  <button id="render" class="primary">Dessiner</button>
</header>
<main>
  <section class="editor" id="editor">
    <div class="lbl">JSON de l'AST</div>
    <textarea id="json" spellcheck="false"></textarea>
  </section>
  <section class="stage grab" id="stage">
    <div id="viewport"></div>
    <div class="err" id="err"></div>
    <div class="hud">
      <button id="zout">&minus;</button>
      <div class="z" id="zlabel">100%</div>
      <button id="zin">+</button>
    </div>
  </section>
</main>
 
<script type="application/json" id="astData">__AST_JSON__</script>
__VIZ_TAG__
<script>
(function(){
  "use strict";
  function escHtml(s){return String(s).replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;").replace(/"/g,"&quot;");}
  function isRef(v){return v&&typeof v==="object"&&!Array.isArray(v)&&Object.prototype.hasOwnProperty.call(v,"_ref");}
  function isNode(v){return v&&typeof v==="object"&&!Array.isArray(v)&&(Object.prototype.hasOwnProperty.call(v,"_id")||Object.prototype.hasOwnProperty.call(v,"_type"));}
  function fmtScalar(v){if(v===null)return "null";if(typeof v==="string")return '"'+v+'"';return String(v);}
  function scalarArray(a){return a.every(function(x){return x===null||typeof x!=="object";});}
 
  var C={hdr:"#2d3b52",id:"#8aa0c0",str:"#4a9d6a",num:"#c08a3e",nul:"#7a8aa0",ref:"#c07a7a"};
 
  function toDot(root){
    var nodes=[], edges=[], done={}, auto=-1;
    function nid(o){ if(o._id===undefined){o._id="a"+(++auto);} return "n"+o._id; }
    function emit(o){
      var id=nid(o);
      if(done[id])return; done[id]=1;
      var type=o._type||"object", rows="", port=0;
      rows+='<tr><td bgcolor="'+C.hdr+'" port="__h"><font color="#ffffff"><b>'+escHtml(type)+'</b></font><font color="'+C.id+'">  #'+o._id+'</font></td></tr>';
      Object.keys(o).forEach(function(key){
        if(key==="_id"||key==="_type")return;
        var val=o[key];
        if(isRef(val)){
          var p="p"+(port++);
          rows+='<tr><td align="left" port="'+p+'">'+escHtml(key)+' <font color="'+C.ref+'">&#8594; #'+val._ref+'</font></td></tr>';
          edges.push("  "+id+":"+p+" -> n"+val._ref+' [style=dashed,color="'+C.ref+'",constraint=false];');
        }else if(isNode(val)){
          var p2="p"+(port++);
          rows+='<tr><td align="left" port="'+p2+'">'+escHtml(key)+'</td></tr>';
          edges.push("  "+id+":"+p2+" -> "+nid(val)+";"); emit(val);
        }else if(Array.isArray(val)){
          if(val.length===0){
            rows+='<tr><td align="left">'+escHtml(key)+' <font color="'+C.nul+'">= []</font></td></tr>';
          }else if(scalarArray(val)){
            rows+='<tr><td align="left">'+escHtml(key)+' <font color="'+C.str+'">= ['+escHtml(val.map(fmtScalar).join(", "))+']</font></td></tr>';
          }else{
            var p3="p"+(port++);
            rows+='<tr><td align="left" port="'+p3+'">'+escHtml(key)+' <font color="'+C.nul+'">['+val.length+']</font></td></tr>';
            val.forEach(function(item,i){
              if(isRef(item)) edges.push("  "+id+":"+p3+" -> n"+item._ref+' [label="'+i+'",style=dashed,color="'+C.ref+'",constraint=false];');
              else if(isNode(item)){ edges.push("  "+id+":"+p3+" -> "+nid(item)+' [label="'+i+'"];'); emit(item); }
            });
          }
        }else{
          var col=val===null?C.nul:(typeof val==="string"?C.str:C.num);
          rows+='<tr><td align="left">'+escHtml(key)+' <font color="'+col+'">= '+escHtml(fmtScalar(val))+'</font></td></tr>';
        }
      });
      nodes.push("  "+id+' [label=<<table border="0" cellborder="1" cellspacing="0" cellpadding="6">'+rows+'</table>>];');
    }
    if(isNode(root)) emit(root);
    else if(Array.isArray(root)) root.forEach(function(x){if(isNode(x))emit(x);});
    else Object.keys(root).forEach(function(k){var v=root[k];if(Array.isArray(v))v.forEach(function(x){if(isNode(x))emit(x);});else if(isNode(v))emit(v);});
 
    return [
      "digraph AST {",
      '  bgcolor="transparent";',
      "  rankdir=TB;",
      '  node [shape=plaintext,fontname="monospace",fontsize=11,color="#3a4a5e"];',
      '  edge [color="#5a6b82",penwidth=1.1,arrowsize=0.7,fontname="monospace",fontsize=9,fontcolor="#6a7d94"];',
      "",
      nodes.join("\\n"),
      "",
      edges.join("\\n"),
      "}"
    ].join("\\n");
  }
 
  var $=function(id){return document.getElementById(id);};
  var ta=$("json"), stage=$("stage"), vp=$("viewport"), errBox=$("err");
  var scale=1, tx=0, ty=0;
 
  function showErr(m){errBox.textContent=m;errBox.style.display="block";}
  function hideErr(){errBox.style.display="none";}
  function applyTransform(){vp.style.transform="translate("+tx+"px,"+ty+"px) scale("+scale+")";$("zlabel").textContent=Math.round(scale*100)+"%";}
 
  function render(){
    hideErr();
    var data;
    try{ data=JSON.parse(ta.value); }
    catch(e){ showErr("JSON invalide : "+e.message); return; }
    var dot;
    try{ dot=toDot(data); }
    catch(e){ showErr("Erreur de conversion : "+e.message); return; }
    Viz.instance().then(function(viz){
      var svg;
      try{ svg=viz.renderSVGElement(dot); }
      catch(e){ showErr("Graphviz : "+e.message); return; }
      vp.innerHTML=""; vp.appendChild(svg);
      fit();
    }).catch(function(e){ showErr("Chargement de Graphviz impossible : "+e.message); });
  }
 
  function fit(){
    var svg=vp.querySelector("svg"); if(!svg)return;
    var b=svg.getBBox?svg.getBBox():null;
    var w=svg.width.baseVal.value||(b&&b.width)||100, h=svg.height.baseVal.value||(b&&b.height)||100;
    var rect=stage.getBoundingClientRect(), pad=48;
    scale=Math.min((rect.width-pad)/w,(rect.height-pad)/h,1.5);
    tx=(rect.width-w*scale)/2; ty=(rect.height-h*scale)/2; applyTransform();
  }
 
  var dragging=false,sx,sy,ox,oy;
  stage.addEventListener("mousedown",function(e){if(e.target.closest(".hud"))return;dragging=true;stage.classList.add("grabbing");sx=e.clientX;sy=e.clientY;ox=tx;oy=ty;});
  window.addEventListener("mousemove",function(e){if(!dragging)return;tx=ox+(e.clientX-sx);ty=oy+(e.clientY-sy);applyTransform();});
  window.addEventListener("mouseup",function(){dragging=false;stage.classList.remove("grabbing");});
  stage.addEventListener("wheel",function(e){
    e.preventDefault();
    var rect=stage.getBoundingClientRect(),mx=e.clientX-rect.left,my=e.clientY-rect.top;
    var f=Math.exp(-e.deltaY*0.0015),ns=Math.max(0.1,Math.min(6,scale*f));
    tx=mx-(mx-tx)*(ns/scale); ty=my-(my-ty)*(ns/scale); scale=ns; applyTransform();
  },{passive:false});
  function zoomBy(f){var rect=stage.getBoundingClientRect(),mx=rect.width/2,my=rect.height/2,ns=Math.max(0.1,Math.min(6,scale*f));tx=mx-(mx-tx)*(ns/scale);ty=my-(my-ty)*(ns/scale);scale=ns;applyTransform();}
 
  $("render").onclick=render;
  $("fit").onclick=fit;
  $("zin").onclick=function(){zoomBy(1.2);};
  $("zout").onclick=function(){zoomBy(1/1.2);};
  $("toggleEditor").onclick=function(){$("editor").classList.toggle("collapsed");setTimeout(fit,200);};
  $("dl").onclick=function(){
    var svg=vp.querySelector("svg"); if(!svg){showErr("Rien à exporter.");return;}
    var blob=new Blob([new XMLSerializer().serializeToString(svg)],{type:"image/svg+xml"});
    var a=document.createElement("a");a.href=URL.createObjectURL(blob);a.download="ast.svg";a.click();URL.revokeObjectURL(a.href);
  };
  ta.addEventListener("keydown",function(e){if((e.ctrlKey||e.metaKey)&&e.key==="Enter")render();});
 
  // charge l'AST embarqué puis dessine
  try{
    var embedded=JSON.parse(document.getElementById("astData").textContent);
    ta.value=JSON.stringify(embedded,null,2);
  }catch(e){ /* pas de données embarquées */ }
  render();
})();
</script>
</body>
</html>
""";
 
    public static String toHtml(Object root) {
        String json = toJson(root).replace("</", "<\\/");
        return HTML_TEMPLATE
                .replace("__AST_JSON__", json)
                .replace("__VIZ_TAG__", vizTag());
    }
 
    public static Path toHtml(Object root, Path out) {
        try {
            Files.writeString(out, toHtml(root), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return out;
    }
 
    private static String vizTag() {
        String js = tryLoadViz();
        if (js != null) {
            return "<script>" + js + "</script>";
        }
        return "<script src=\"viz-standalone.js\"></script>";
    }
 
    private static String tryLoadViz() {
        try (var in = Ast.class.getResourceAsStream("/viz-standalone.js")) {
            if (in != null) {
                return new String(in.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException ignored) {
        }
        Path p = Path.of("viz-standalone.js");
        if (Files.isRegularFile(p)) {
            try {
                return Files.readString(p, StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
        return null;
    }

    // ===========
}
