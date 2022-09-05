package com.fnd.games_store.gateway.jwt_utils;


import lombok.extern.slf4j.Slf4j;
//@Component
@Slf4j
public class JwtFilter{

//
//    LoginServiceClient loginClient;
//
//    @Autowired
//    public JwtFilter(LoginServiceClient loginClient) {
//        this.loginClient = loginClient;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//
//        String tokenHeader = request.getHeader("Authorization");
//
//        String incomingToken = tokenHeader.substring(7);
//
//        log.info("incoming token: "+ incomingToken);
//
//        ValidationRequestDTO userValidationRequestDTO = new ValidationRequestDTO(incomingToken);
//
//        Boolean isUserValid = loginClient.validateUserByToken(userValidationRequestDTO).getUserValid();
//
//        if(isUserValid){
//            filterChain.doFilter(request, response);
//        } else throw new UserValidateFailedException("User validation failed");

//    }
}
