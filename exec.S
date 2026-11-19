.globl _start

.section .rodata

.text
_start:
	mov $0, %rdi
	mov $1, %rsi
	mov $4, %rdx
	call my_if
	mov $1, %rdi
	call my_exit
	ret
