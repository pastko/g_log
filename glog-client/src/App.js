import React from 'react';
import { Switch, Route} from 'react-router-dom';
import Home from './pages/Home';
import Profile from './pages/mypage/Profile';
import Write from './pages/board/Write';
import Header from "./components/common/Header";
import styled from 'styled-components';


function App() {
  return (
    <Switch>
      <Route path='/write' exact component={Write} />
      <Route
        exact
        path="*"
        component={() => (
          <StyledWithHeader>
            <Header />
            <Route exact path='/' component={Home} />
            <Route path='/profile' component={Profile} />
          </StyledWithHeader>
        )}
      />
    </Switch>
  );
}

const StyledWithHeader = styled.div`
  width: 1280px;
  margin: 0 auto;
`;


export default App;
