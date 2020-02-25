package com.interviews.bolt;

import java.util.*;

/*
'(', '{', '[' are called "openers".
')', '}', ']' are called "closers".
Write an efficient function that tells us whether input string's openers and closers are properly nested.


Examples:
"{ [ ] ( ) }" -> true
"{ [ ( ] ) }" -> false
"{ [ }" -> false
"class Example { public do() { return; } }" -> true
"class Example { public do( { return; } }" -> false


Add support for 3 self-closing parentheses: " ' |

"''" -> true
"'''" -> false
"'||'" -> true
"'|'|" -> false
*/

public class ValidateParenthesis {
    private static final Set<Character> VALID_CHARACTERS = new HashSet<>(9);
    private static final Set<Character> SELF_CLOSING_CHARACTERS = new HashSet<>(3);
    private static final Map<Character, Character> CHARACTER_MAP = new HashMap<>(3);

    static {
        SELF_CLOSING_CHARACTERS.add('\'');
        SELF_CLOSING_CHARACTERS.add('\"');
        SELF_CLOSING_CHARACTERS.add('|');

        VALID_CHARACTERS.addAll(SELF_CLOSING_CHARACTERS);

        CHARACTER_MAP.put(')', '(');
        CHARACTER_MAP.put('}', '{');
        CHARACTER_MAP.put(']', '[');

        CHARACTER_MAP.entrySet().forEach(entry -> {
            VALID_CHARACTERS.add(entry.getKey());
            VALID_CHARACTERS.add(entry.getValue());

        });
    }

    public static void main(String args[]) throws Exception {
        System.out.println(validate("  { \" \' ( ) } \' \"   ")); // false
        System.out.println(validate("{\"\'(}\'\""));
        System.out.println(validate("{ \" \' \' \" ()}"));

        System.out.println(validate("Validating not closing"));

        System.out.println(validate("{ [ ] ( ) }"));
        System.out.println(validate("{ [ ( "));
        System.out.println(validate(") } ]"));
        System.out.println(validate("{ }[ ( ]"));
        System.out.println(validate("[ { ( ) } ]"));
        System.out.println(validate("( { [ ] } )"));
    }

    public static boolean validate(String input) {
        Stack<Character> stack = new Stack<>();

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];

            if (VALID_CHARACTERS.contains(curChar)) {
                if (SELF_CLOSING_CHARACTERS.contains(curChar)) {
                    if (stack.isEmpty() || stack.peek() != curChar) {
                        stack.push(curChar);
                    } else {
                        stack.pop();
                    }
                } else if (CHARACTER_MAP.containsKey(curChar)) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != CHARACTER_MAP.get(curChar)) {
                        return false;
                    }

                } else {
                    stack.push(curChar);
                }
            }
        }

        return stack.isEmpty();
    }
} 