package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            List<String> list = new ArrayList<>();

            String ss;
            while(true) {
                ss = br.readLine();

                if(ss.equals("END")) break;
                if(ss.equals("QUIT")) break;

                list.add(ss);
            }
            if(ss.equals("QUIT"))
                break;


            Long N = Long.parseLong(br.readLine());
            boolean isError = false;
            for(int i = 0; i < N; i++) {
                isError = false;
                Long num = Long.parseLong(br.readLine());
                Stack<Long> stack = new Stack<>();
                stack.push(num);

                for(String s : list) {
                    if(s.contains("NUM")) {
                        StringTokenizer st = new StringTokenizer(s, " ");
                        st.nextToken();
                        stack.push(Long.parseLong(st.nextToken()));
                    }
                    else if(s.equals("POP")) {
                        if(stack.isEmpty()) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else stack.pop();
                    }
                    else if(s.equals("INV")) {
                        if(stack.isEmpty()) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long n = stack.pop();
                            n = (-1) * n;
                            stack.push(n);
                        }
                    }
                    else if(s.equals("DUP")) {
                        if(stack.isEmpty()) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long n = stack.peek();
                            stack.push(n);
                        }
                    }
                    else if(s.equals("SWP")) {
                        if(stack.size() < 2) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long a = stack.pop();
                            Long b = stack.pop();
                            stack.push(a);
                            stack.push(b);
                        }
                    }
                    else if(s.equals("ADD")) {
                        if(stack.size() < 2) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long a = stack.pop();
                            Long b = stack.pop();
                            if(Math.abs(a+b) > Math.pow(10,9) || Math.pow(10,9)*(-1) > Math.abs(a+b)) {
                                sb.append("ERROR").append("\n");
                                isError = true;
                                break;
                            }
                            stack.push(a + b);
                        }
                    }
                    else if(s.equals("SUB")) {
                        if(stack.size() < 2) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long a = stack.pop();
                            Long b = stack.pop();
                            if(Math.abs(b-a) > Math.pow(10,9)|| Math.pow(10,9)*(-1) > Math.abs(b-a)) {
                                sb.append("ERROR").append("\n");
                                isError = true;
                                break;
                            }
                            stack.push(b - a);
                        }
                    }
                    else if(s.equals("MUL")) {
                        if(stack.size() < 2) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long a = stack.pop();
                            Long b = stack.pop();
                            if(Math.abs(a*b) > Math.pow(10,9) || Math.pow(10,9)*(-1) > Math.abs(a*b)) {
                                sb.append("ERROR").append("\n");
                                isError = true;
                                break;
                            }
                            stack.push(a*b);
                        }
                    }
                    else if(s.equals("DIV")) {
                        if(stack.size() < 2) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long a = stack.pop();
                            Long b = stack.pop();
                            if(a == 0) {
                                sb.append("ERROR").append("\n");
                                isError = true;
                                break;
                            }

                            if((a > 0 && b < 0) || (a < 0 && b > 0))
                                stack.push((Math.abs(b)/Math.abs(a))*(-1));
                            else
                                stack.push(Math.abs(b)/Math.abs(a));
                        }
                    }
                    else if(s.equals("MOD")) {
                        if(stack.size() < 2) {
                            sb.append("ERROR").append("\n");
                            isError = true;
                            break;
                        }
                        else {
                            Long a = stack.pop();
                            Long b = stack.pop();
                            if(a == 0) {
                                sb.append("ERROR").append("\n");
                                isError = true;
                                break;
                            }
                            if(b < 0)
                                stack.push(Math.abs(b) % Math.abs(a) * (-1));
                            else
                                stack.push(Math.abs(b) % Math.abs(a));

                        }
                    }
                    else if(s.equals("END"))
                        break;
                }

                if(stack.size() != 1 && isError == false) {
                    sb.append("ERROR").append("\n");
                }
                else if(isError == false)
                    sb.append(stack.peek()).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
