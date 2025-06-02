.data
mytam: 		.word 8
myvect: 	.word 8,-3,4,-2,5,7,6,1
myres: 		.word 0

.text
.global main
main:	push {lr}
		ldr r0,=myvect
		ldr r1,=mytam
		ldr r1,[r1]
		bl absmax
		ldr r1,=myres
		str r0,[r1]
		pop {lr}
		mov pc, lr
		
abs: 	mov r1,#0
		cmp r0,r1
		sublt r0,r1,r0
		mov pc, lr
		
absmax:	push {lr}
		ldr r4, =myvect
		ldr r3,[r4]
		bucle:	cmp r1,#0
		beq salir
		ldr r0,[r4],#4
		push {r1}
		bl abs
		pop {r1}
		cmp r0,r3
		blt siguiente
		mov r3,r0
		siguiente: 
		sub r1,r1,#1
		b bucle
		
		salir:
		mov r0,r3
		pop {lr}
		mov pc, lr