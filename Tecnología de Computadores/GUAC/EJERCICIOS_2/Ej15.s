.data
tam: .word 8
datos: .word 14,20,10,-3,-12,2,-4,-6
res: .word 0
retardo: .word 0xFFFF

.text
.global main
main: 
		ldr r0,=tam
		ldr r1,[r0]
		ldr r2,=datos
		ldr r3, [r2]
		
		stmdb sp!,{lr}
		bl pantalla
		ldmia sp!,{lr}
		
		stmdb sp!,{lr}
		bl minimo
		ldmia sp!,{lr}
		
		
		stmdb sp!,{lr}
		bl pantallaminimo
		ldmia sp!,{lr}
		
		str r0, [r3]
		bx lr
		
	pantalla:
		stmdb sp!,{r1,r2}
		stmdb sp!, {lr}
		ldr r8,=datos
		mov r7,#8
		ldr r1,[r1]
		ldr r0,[r0]
		
		bucle: 
			ldr r2, [r8], #4
			mov r1,#1
			mov r0,#1
			bl muestra_entero_consigno
			ldr r6,=retardo
			ldr r6,[r6]
			bucle2: subS r6,r6,#1
				bNE bucle2
				bl limpia_pantalla
				subS r7,r7,#1
				bNE bucle
	
		ldmia sp!, {lr}
		ldmia sp!, {r1-r2}
		bx lr
		
	pantallaminimo:
		stmdb sp!,{r1,r2}
		ldr r2, [r0]
		mov r1, #1
		mov r0, #1
		
		stmdb sp!, {lr}
		bl muestra_entero_consigno
		ldmia sp!, {lr}
		ldmia sp!, {r1-r2}
		bx lr	
		
	minimo:
		stmdb sp!,{r2-r4}
		ldr r3,[r2]
		
		loop:	
			cmp r1, #0
			beq fin
			ldr r4, [r2], #4
			cmp r4, r3
			bgt siguiente
			mov r3, r4
	
		siguiente: 
			sub r1, r1, #1
			b loop

		fin:	
			ldr r0,=res
			str r3, [r0]
			
			ldmia sp!,{r2-r4}
			
			bx lr