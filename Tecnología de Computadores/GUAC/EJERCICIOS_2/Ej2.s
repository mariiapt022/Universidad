	
.equ CERO,0xED
.text
.global main
main:
		mov r0,#CERO
		swi 0x200			
		mov r2, #0xFF		
		mov r2, r2, lsl #8	
		add r2,r2,#0xFF
		mov r3,#0
		mov r4,#1
		mov r5,#0
		
	bucle: cmp r4,#8
		beq fin
		movS r0, r0, lsr #7
		addNE r3,r3,#1
		add r4,r4,#1
		b bucle
		
	fin: 
		mov r3,r0
		swi 0x200
		mov r2, #0xFF		
		mov r2, r2, lsl #8	 
		add r2,r2,#0xFF
		bx lr