.data
 filename: .asciiz "test.txt"
 fill: .byte	 '0','0','0','0','0','0','0','0','0'
 result: .byte	 '0','0','0','0','0','0','0','0','0'
 buffer: .space 400000
 table: .asciiz "0123456789abcdef"
.text
main:
    # open file
    li $v0, 13
    la $a0, filename
    li $a1, 0 # 0 for read
    li $a2, 0
    syscall
    
    move $s6, $v0 # save file descriptor
    
    # read file
    li $v0,14
    move $a0,$s6 # load file descriptor
    la $a1, buffer # save read content to buffer space
    li $a2, 40 # reads 40 ascii chars
    syscall
    li $s0,0
    li $s1,0
 
loop:
    bge $s1,40,loopDone
    la $a0, buffer
    add $a0,$a0,$s1
    
    li $a1,4
    li $a2,16
    jal str2int
    
    add $s0,$s0,$v1
    
    addi $s1,$s1,4
    
    j loop
loopDone:  

    
    subiu $sp, $sp, 40
    
    move $a0,$s0
    move $a1,$sp
    jal print16
    
    la $t0,fill
    add $t1,$sp,$v0
    addi $t0,$t0,8
fill8bit:
  
    bgt $sp,$t1,fill8bitDone
    lb $t2,($t1)
    sb $t2,($t0)
    addi $t1,$t1,-1
    addi $t0,$t0,-1
    
    j fill8bit
fill8bitDone:


    la $a0, fill

    li $a1,4
    li $a2,16
    jal str2int
    move $s1,$v1
    beqz $v1,notTruncate
    la $a0, fill
    addi $a0,$a0,4
    li $a1,4
    li $a2,16
    jal str2int
    add $s1,$s1,$v1 #2 + 479c = 479e 
notTruncate:
    # ones' complement
    li $t0,0xFFFF
    sub $s1,$t0,$s1
    


    li $a0,'0'
    li $v0,11
    syscall
    li $a0,'x'
    li $v0,11
    syscall
    
    move $a0,$s1
    move $a1,$sp
    jal print16
    
    la $t0,result
    add $t1,$sp,$v0
    addi $t0,$t0,8
fill8bit1:
  
    bgt $sp,$t1,fill8bitDone1
    lb $t2,($t1)
    sb $t2,($t0)
    addi $t1,$t1,-1
    addi $t0,$t0,-1
    
    j fill8bit1
fill8bitDone1:
    
    
    
    
    la $a0,result
    li $v0,4
    syscall
    
    addiu $sp, $sp, 40
    li $v0,10
    syscall
    
    
# ----------
# procedure: str2int
# $a0 = starting address of buffer
# $a1 = lent
# $a2 = base
# return value = $v1
# return flag $v0: 0-wrong, 1-correct
# -----------
.globl str2int
str2int:
    subiu $sp, $sp, 40
    sw  $ra, 0($sp)
    sw  $s0, 4($sp)
    sw  $s1, 8($sp)


    move $s0,$a1
    li $v0, 1
    li $v1, 0
    li $s1, 0 
    li $s2, 1


	# TODO
    add $a0, $a0, $s0
    addi $a0, $a0, -1

str2int_0:
    lb $t0, 0($a0)
    beq $s1, $s0, str2int_ret 
    subiu $t0, $t0, '0' 
    bge $t0, 10, isHex 
isHex:
    ble $t0, 9, isLess10
    subiu $t0, $t0, 39 
isLess10:
    bge $t0, $a2, str2int_err 
    mul $t1, $t0, $s2
    mul $s2, $s2, $a2
    add $v1, $v1, $t1
    
    addi $s1, $s1, 1
    addi $a0, $a0, -1
    j str2int_0
str2int_err:
    li $v0, 0
str2int_ret:
    
    lw  $ra, 0($sp)
    lw  $s0, 4($sp)
    lw  $s1, 8($sp)
    addiu $sp, $sp, 40
    jr $ra
    
    
    

# ----------
# procedure: print16
# $a0 = the integer to print
# $a1 = save buffer
# return value: $v1 = $a0
# -----------
.globl print16
print16:
    # TODO
    subiu $sp, $sp, 40
    sw  $ra, 0($sp)
    sw  $s0, 4($sp)
    sw  $s1, 8($sp)
    
    move $s0, $a0

    li $v0,0
    li $t1, 32 
print16_rol:
    rol $s0, $s0, 4
    and $t0, $s0, 0x0F
    subiu $t1, $t1, 4
    beq $t0, 0, print16_rol
    ror $s0, $s0, 4 
    addi $t1, $t1, 4
    
print16_0: 
    rol $s0, $s0, 4
    and $t0, $s0, 0xf
    lb $t0, table($t0)
    
    addi $v0,$v0,1
    sb $t0,($a1)
    
    addi $a1,$a1,1
    sb $0,($a1)
    
    
    subiu $t1, $t1, 4
    bne $t1, 0, print16_0
    
    lw  $ra, 0($sp)
    lw  $s0, 4($sp)
    lw  $s1, 8($sp)
    addiu $sp, $sp, 40
    jr $ra
#.end print16
