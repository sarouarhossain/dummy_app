import http from "./http-common";

class ApiService {
  postData(){
    return http.post("/abcd")
  }

  getData() {
    return http.get("/abcd")
  }
}

export default new ApiService()