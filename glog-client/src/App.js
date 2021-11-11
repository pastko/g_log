import React from 'react';
import { Switch, Route} from 'react-router-dom';
import Home from './pages/Home';
import Profile from './pages/mypage/Profile';
import BoardWrite from './pages/board/BoardWrite';
import './App.css'


function App() {
  return (
    <div className="appContainer">
      <Switch>
        <Route exact path='/'>
          <Home/>
        </Route>
        <Route path='/profile'>
          <Profile/>
        </Route>
        <Route path='/boardWrite'>
          <BoardWrite/>
        </Route>
      </Switch>
    </div>
  );
}

export default App;
