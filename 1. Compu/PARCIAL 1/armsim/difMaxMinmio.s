.data
numel: .word 5
vector: .word -1,-2,-3,-4,-5
resultado: .word 0

.text
.global main
main:
		ldr r0,=numel
		ldr r0,[r0]
		ldr r1,=vector
		ldr r2,=resultado
		ldr r3,[r1]			@r3 guardar minimo
		ldr r4,[r1]			@r4 guardar maximo
		mov r5,#0
		
		bucle: cmp r0,#0
			beq resta
			ldr r5,[r1],#4
			cmp r5,r3
			blt minimo
			cmp r5,r4
			bgt maximo
		seguir:
			sub r0,r0,#1
			b bucle
			b resta
		minimo:
			add r3,r5,#0
			b seguir
		maximo:
			add r4,r5,#0
			b seguir
			
		resta: sub r4,r4,r3
			str r4,[r2]
			bx lr