.data 0x0000				      		
	buf: .word 0x0000
.text 0x0000						
start: 				
	lw   $1,0xC70($31)				
	sw   $1,0xC60($31)	
	
	lw   $1,0xC72($31)				
	sw   $1,0xC62($31)	
	j start