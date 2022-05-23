package com.main.leetcode;

public class LeetCodeSolution {
        public static void main(String[] args) {

            String s = "ab#cd#";
            String t = "ad#cb#";
            String u = "#bd##cb#";
            String v = "#";
            System.out.println(s+":"+getProcessedStr(s));
            System.out.println(t+":"+getProcessedStr(t));
            System.out.println(u+":"+getProcessedStr(u));
            System.out.println(v+":"+getProcessedStr(v));

        }
        public static String getProcessedStr(String input) {
            if(null!=input && !input.isEmpty()) {
                int j =0;
                StringBuilder  sb = new StringBuilder();
                for(char c : input.toCharArray()) {
                    if(c!='#') {
                        sb.append(c);
                        j++;
                    }else if(c=='#' && j!=0) {
                        sb.deleteCharAt(j-1);
                        j--;
                    }
                }
                return sb.toString();
            }
            return "";
        }

    }
