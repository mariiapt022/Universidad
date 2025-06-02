.data
tamval: .word 4
tamdat: .word 15
datos: .word 2,4,2,8,2,4,2,7,5,6,5,3,7,6,8
valores: .word 2,4,6,9
res: .word 0,0,0,0

.text
.global main
main:
		push {lr}
		ldr r0, =valores
		ldr r1,=datos
		ldr r4,=res
		ldr r2,=tamdat
		ldr r2,[r2]
		ldr r3,=tamval
		ldr r3,[r3]
		
		loop: 
		push {r1,r2}
		ldr r5,[r0],#4		@cargo en r5 el numero de valores q toque
		bl hist 			@la solucion la quiero en r5
		ldr r4,[r6],#4		@cargo en res el r6
		pop {r1,r2}
		subS r3,r3,#1		@r3 contador del datos
		bNE loop
		
		ldr r1,=res
		str r0,[r1]
		pop {lr}
		mov pc, lr
		
hist:
		mov r6,#0
		bucle: 
		ldr r7,[r1],#4
		subS r7,r7,r5
		bNE seguir
		add r6,r6,#1
		seguir:
		subS r2,r2,#1
		bNE bucle
		b salir
		
		salir: 
			bx lr