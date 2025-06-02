.data
tam:	.word 8
datos:	.word 2,4,6,8,-2,-4,-6,-7
res:	.word 0
cad:	.asciz "Maximo="
.text	
.global main
	main:	
		ldr r0, =tam
		ldr r1, [r0]
		ldr r2, =datos
		ldr r3, [r2]
		
		stmdb sp!,{lr}
		bl maximo
		ldmia sp!,{lr}
		
		str r0, [r2]
		
		stmdb sp!,{lr}
		bl pantalla
		ldmia sp!,{lr}
		
		stmdb sp!,{lr}
		bl salida
		ldmia sp!,{lr}
		
		
		bx lr
		
	maximo:
		stmdb sp!,{r2-r4}
		ldr r3,[r2]
		
		loop:	
			cmp r1, #0
			beq fin
			ldr r4, [r2], #4
			cmp r4, r3
			blt siguiente
			mov r3, r4
	
		siguiente: 
			sub r1, r1, #1
			b loop

		fin:	
			ldr r0,=res
			str r3, [r0]
			
			ldmia sp!,{r2-r4}
			
			bx lr
			
	pantalla:
		stmdb sp!,{r0-r2}
		ldr r2, [r0]
		mov r1, #1
		mov r0, #1
		
		stmdb sp!, {lr}
		bl muestra_entero_consigno
		ldmia sp!, {lr}
		ldmia sp!, {r0-r2}
		
		bx lr
		
	salida: 
		stmdb sp!,{r0-r2}
		ldr r2, =cad
		mov r1,#0
		mov r0,#1
		
		stmdb sp!, {lr}
		bl muestra_cadena
		ldmia sp!, {lr}
		ldmia sp!, {r0-r2}
		
		stmdb sp!,{lr}
		bl pantalla
		ldmia sp!,{lr}
		
		
	
	
		
	
	
	