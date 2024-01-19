const base = {
    get() {
                return {
            url : "http://localhost:8080/bishe/",
            name: "bishe",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/bishe/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "网上鲜花交易平台"
        } 
    }
}
export default base
