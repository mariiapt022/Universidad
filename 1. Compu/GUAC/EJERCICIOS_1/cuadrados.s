.text
cuad: 
		cmp r0, #0 		
		movle r0, #0 	
		bxle lr 		
		mov r1,#0 
		mov r2,#0 
	loop:
		cmp r2,r0
		bgt fin
		mul r3,r2,r2
		add r1,r1,r3
		add r2,r2,#1
		b loop
	fin:
		mov r0,r1
		bx lr