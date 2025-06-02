#lang racket
(require (for-syntax syntax/parse))

(define-syntax (print form)
  (syntax-parse form
    ((print arg:expr ...)
     #`(begin
         (display arg) ...
         (newline)))))