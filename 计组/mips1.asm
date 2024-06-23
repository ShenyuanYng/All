.data
s1: .ascii "Welcome "
sid: .space 9
e1: .asciiz " to MIPS World"
bb: .asscii" "
.text
main:
li $v0,8 #to get a string
la $a0,sid
li $a1,9
syscall
la $t0,bb
sb $t0,8($a0)


li $v0,4 #to print a string
la $a0,s1
syscall
li $v0,10 #to exit
syscall
