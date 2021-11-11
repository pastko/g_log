import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import Header from './components/common/Header';
import './index.css'

ReactDOM.render(
  <BrowserRouter>
    <Header />
    <App />
  </BrowserRouter>,
  document.getElementById('root')
);
