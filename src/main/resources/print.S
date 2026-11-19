.globl print_string
print_string:
    cmp $0, %rdi
    jne .next
    ret

.next:
    mov $0, %rsi
    mov (%rdi), %sil
    call print_char
    cmp $0, %rsi
    je .fin
    inc %rdi
    jmp print_string
    ret

.fin:
    mov $0, %rdi
    ret
