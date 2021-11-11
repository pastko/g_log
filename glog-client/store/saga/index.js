import { all, call } from 'redux-saga/effects';
import userinfosaga from './userinfosaga';

export default function* rootSaga(){
    yield all([call(userinfosaga)])
}