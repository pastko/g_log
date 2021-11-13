import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import Header from "./components/common/Header";
import { Provider } from 'react-redux';
import store from './store/configureStore';
import "./index.css";

ReactDOM.render(
  <Provider store={store}>
  <BrowserRouter>
    <Header />
    <App />
  </BrowserRouter>,
  </Provider>,
  document.getElementById("root")
);
