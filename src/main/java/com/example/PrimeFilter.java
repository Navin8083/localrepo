package com.example;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

public class PrimeFilter extends HttpFilter implements Filter {

    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        // Cleanup code, if any
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        int n = Integer.parseInt(request.getParameter("number"));
        boolean isPrime = true;

        // Check if number is less than 2, which is not prime
        if (n < 2) {
            isPrime = false;
        } else {
            // Check divisibility starting from 2 up to the square root of n
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            response.getWriter().write(" "+n+ " is a Prime number.");
        } else {
            response.getWriter().write(""+n+ " is not Prime number.");
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code, if any
    }
}
