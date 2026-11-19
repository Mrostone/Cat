.globl my_if
my_if:
    cmp $0, %rdx
    je .eq

    cmp $1, %rdx
    je .neq

    cmp $2, %rdx
    je .le

    cmp $3, %rdx
    je .ge

    cmp $4, %rdx
    je .l

    cmp $5, %rdx
    je .g

    mov $120, %rdi
    call my_exit

    #ici on a just pas un bon argument pour le comparateur
    ret

.eq:
    cmp %rdi, %rsi
    je .true
    jmp .false

.neq:
    cmp %rdi, %rsi
    jne .true
    jmp .false

.le:
    cmp %rsi, %rdi
    jle .true
    jmp .false


.ge:
    cmp %rsi, %rdi
    jge .true
    jmp .false


.l:
    cmp %rsi, %rdi
    jl .true
    jmp .false


.g:
    cmp %rsi, %rdi
    jg .true
    jmp .false

.true:
    mov $1, %rax
    ret

.false:
    mov $0, %rax
    ret
