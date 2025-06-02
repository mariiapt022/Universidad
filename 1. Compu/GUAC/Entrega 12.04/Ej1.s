.data
tam:	.word 8
datos:	.word 2, 4, 6, 8, -2, -4, -6, -7
res:	.word 0

.text	
.global main

	main:	
		ldr r0, =tam
		ldr r1, [r0]
		ldr r2, =datos
		ldr r3, [r2]		@cargamos en r3 el primer elemento del vector, en r3 vamos a ir guardando el mayor de las comparaciones
		
	loop:	
		cmp r1, #0			@vamos comparando r1 con 0 para recorrer todo el vector
		beq fin				@termina el bucle cuando r1=0
		ldr r4, [r2], #4	@cargamos en r4 el siguiente elemento del vector (el primero ya lo tenemos en r3)
		cmp r4, r3			@comparamos el mayor ya guardado con el nuevo elemento del vector
		blt siguiente		@en el caso que r4 sea menor que r3 vamos a siguiente
		mov r3, r4			@en el caso que r4 sea mayor que r3 los cambiamos
	
	siguiente: 
		sub r1, r1, #1		@disminuimos una unidad en el índice del tamaño
		b loop				@volvemos al bucle

	fin:	
		ldr r0, =res
		str r3, [r0]
				
		ldr r2, [r0]
		mov r1, #1
		mov r0, #1
		bl muestra_entero_consigno
		bx lr
