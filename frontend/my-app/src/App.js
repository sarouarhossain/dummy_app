import { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ApiService from "./api-service";


class App extends Component {
  constructor(props) {
    super(props)
    this.setData = this.setData.bind(this)
    this.getData = this.getData.bind(this)
    this.state = {
        data: ""
    }
  }

  componentDidMount() {
      this.setData()
      setInterval(this.setData,40000)
      this.getData()
      setInterval(this.getData,10000)
  }

  setData() {
    ApiService.postData().then((res) => {
          console.log("Response: ")
          console.log(res)
      }).catch((err) => {
          console.log("Error: ")
          console.log(err)
      })
  }

  getData() {
    ApiService.getData().then((res1) => {
      console.log("Response1: ")
      console.log(res1)
      this.setState({
          data: res1.data
       })
      }).catch((err1) => {
          console.log("Error: ")
          console.log(err1)
      })
  }

  render(){
    return (
      <div>
        <div>
          <span>  Hello, {this.state.data}</span>
        </div>
      </div>
    );
  }

}

export default App;
