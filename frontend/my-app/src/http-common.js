import axios from "axios";

const API_BASE_URL = process.env.API_BASE_URL || "http://178.128.16.172:5050"
export default axios.create({
    withCredentials: true,
    baseURL: API_BASE_URL,
    headers: {
      "Content-type": "application/json"
    }
  });