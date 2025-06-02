@María Peinado Toledo

fib:
	cmp r0,#0 		@Si n=1 o n=0 hemos terminado
	bxeq lr
	cmp r0,#1
	bxeq lr
	
	mov r1,#0 		@inicializamos  f_n-2
	mov r2,#1 		@inicializamos  f_n-1
	mov r3,#0 		@inicializamos el resultado a 0
	mov r4,#2 		@contador
	
	loop:
	cmp r4,r0  		@comparamos el contador con n
	beq fin			@en el caso de que sean iguales habríamos terminado el bucle
	add r3,r1,r2	@aplciamos la formula de f_n=f_n-1+f_n-2
	mov r1,r2		@actualizamos f_n-2=f_n-1
	mov r2,r3		@actualizamos f_n-1=f_n
	add r4,r4,#1	@actualizamos el contador
	b loop
	
	fin:
	mov r3, r0		@cargamos el resultado en r0 
	bx lr

		