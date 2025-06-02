fib:	push {r4-r7}
	mov r4, #0 
	mov r5, #1 
	mov r6, #0 
	mov r7, #0 
				
	loop:	cmp r0, r7 
		beq fin 
		add r6, r4, r5  
		mov r5, r4 
		mov r4, r6 
		add r7, r7, #1 
		b loop
		
	fin:
		mov r0, r6
		pop {r4-r7}
		bx lr

		