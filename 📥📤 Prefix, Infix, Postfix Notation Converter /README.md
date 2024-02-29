# Prefix - Infix - Postfix Notation Converter 

## ❔ What is it

Mathematical formulas are often made more accessible by using parenthesis. However, in computers, expressions with multiple parentheses can be inefficient. So, mathematicians have created different notations such as infix, prefix, and postfix expressions to reduce computational work. Thus, in simpler terms they are just different ways of writing and evaluating mathematical expressions!

1. In **Prefix** notation, the operator goes *before* the two operands. Prefix and Postfix notations also have precedence rules like the Infix notation, they will dictate the operators' order after the operands.

2. In **Infix** notation, the operator goes *in between*
   
   Some rules that the mathematical expressions written in Infix notation have to follow are:
     *Parentheses*: expressions inside parentheses are evaluated first
     *Exponentiation*: exponents are evaluated next
     *Multiplication and division*: multiplication and division are evaluated before addition and subtraction
     *Addition and subtraction*: finally, addition and subtraction are evaluated last
  
3. In **Postfix**, the operatory, goes *after* the two operands. 

---

## 👨🏻‍💻 Dev Process

Firstly, I will make the **Infix to Postfix**  converter. For that, I will need to follow a set of rules:
    *Stack data structure will be used*, thus I will need to pop and append elements in accordance to their precedence:
     1. Highest Priority operator: ^
     2. Medium Priority operator: / *
     3. Lowest Priority operators: - +  // the Parenthesis won't be counted as operators

The rules I will have to follow:
    1. No two operators of same priority can stay together in stack. The one pushed on top first will have to be popped before the second one gets added.
    2. Lower priority operators can not be placed on top of those with higher priority, thus the one with higher priority will have to be popped first.
    3. If an operator is enclosed between two parenthesis () in the stack, then it has to be popped.

That being said, I can now begin writing the code for out converter! Woohoo!

## 🗂️ Installation

The code now fully works. I now need to develop the converter into other notation types, making it universal. This will be done a bit later. 

To use my converter, just ddownload the source code, and run it through a java compiling capable terminal. 
    

---

## 🕵️‍♂️ More...

Find more on the development of Infix to Postfix converter method here: https://www.youtube.com/watch?v=vXPL6UavUeA 


