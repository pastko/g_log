import {
  createStore,
  combineReducers,
  applyMiddleware,
  compose
} from 'redux';
import thunk from 'redux-thunk';
import {
  createBrowserHistory
} from 'history';
import {
  connectRouter
} from 'connected-react-router';
import {
  persistStore,
  persistReducer
} from 'redux-persist'
import storage from 'redux-persist/lib/storage'
import User from './reducer/users';
import Comments from './reducer/comments';
import Board from './reducer/board';
import Home from './reducer/home';

export const history = createBrowserHistory();

const rootReducer = combineReducers({
  user: User,
  board: Board,
  comments: Comments,
  home: Home,
  router: connectRouter(history)
});


const persistConfig = {
  key: 'root',
  storage,
}

const middlewares = [thunk.withExtraArgument({
  history: history
})];


const composeEnhancers =
  typeof window === 'object' && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ ?
  window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({
    // Specify extension’s options like name, actionsBlacklist, actionsCreators, serialize...
  }) :
  compose;

const enhancer = composeEnhancers(applyMiddleware(...middlewares));

const persistedReducer = persistReducer(persistConfig, rootReducer)

let storeConfig = () => {
  let store = createStore(persistedReducer, enhancer);
  let persistor = persistStore(store);
  return {
    store,
    persistor
  }
}


export default storeConfig;