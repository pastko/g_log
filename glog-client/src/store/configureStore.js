import createSagaMiddleware, {
  Task
} from "redux-saga";
import {
  createWrapper
} from "next-redux-wrapper";
import {
  Store
} from "redux";
import rootReducer from "./reducer";
import rootSaga from "./saga";

const configureStore = () => {};

const wrapper = createWrapper(configureStore, {
  //debug: process.env.NODE_ENV === "development",
});

export default wrapper;