.globl my_exit
my_exit:
    mov $60, %rax
    syscall
