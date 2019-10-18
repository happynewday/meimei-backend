package com.mm.backend.interceptor;

/**
 * @ClassName RequestHeaderContext
 * @Description TODO
 * @Date 2019/7/8 22:14
 */
public class RequestHeaderContext {
    private static final ThreadLocal<RequestHeaderContext> REQUEST_HEADER_CONTEXT_THREAD_LOCAL=new ThreadLocal<>();
    private String userId;
    private String token;
    private String userLevel;

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getLevel() {
        return userLevel;
    }

    public static RequestHeaderContext getInstance(){
        return REQUEST_HEADER_CONTEXT_THREAD_LOCAL.get();
    }

    public void setContext(RequestHeaderContext context){
        REQUEST_HEADER_CONTEXT_THREAD_LOCAL.set(context);
    }

    public static void clean(){
        REQUEST_HEADER_CONTEXT_THREAD_LOCAL.remove();
    }

    private RequestHeaderContext(RequestHeaderContextBuild requestHeaderContextBuild){
        this.userId=requestHeaderContextBuild.userId;
        this.token=requestHeaderContextBuild.token;
        this.userLevel=requestHeaderContextBuild.userLevel;
        setContext(this);
    }

    public static class RequestHeaderContextBuild{
        private String userId;
        private String token;
        private String userLevel;

        public RequestHeaderContextBuild userId(String userId){
            this.userId=userId;
            return this;
        }

        public RequestHeaderContextBuild token(String token){
            this.token=token;
            return this;
        }

        public RequestHeaderContextBuild userLevel(String level){
            this.userLevel=level;
            return this;
        }

        public RequestHeaderContext bulid(){
            return new RequestHeaderContext(this);
        }
    }
}
