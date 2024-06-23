.macro print_string(%str)
.data
pstr: .asciiz %str
.text
addi $sp,$sp,-8
sw $a0,4($sp)
sw $v0,($sp)
la $a0,pstr
li $v0,4
syscall
lw $v0,($sp)
lw $a0,4($sp)
addi $sp,$sp,8
.end_macro

.macro end
li $v0,10
syscall
.end_macro
