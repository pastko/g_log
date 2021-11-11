import { call, put, takeEvery } from "redux-saga/effects";
import {CHANGE_LOGIN , CHANGE_INFO, CHANGE_FAILURE  } from '../commandType';
import * as action from '../action';

 


function* fetchChangeLogin(isLogin, token) {
    try {
        yield put(action.changelogin(isLogin, token));
    } catch (error) {
        yield put(action.changeerror('error'));
    }
}

function* fetchChangeUserInfo(user) {
    try {
        yield put(action.changeinfo(user));
    } catch (error) {
        yield put(action.changeerror('error'));
    }
}

/**
 * SEARCH DISPATH EVENT WATCH
 * 이벤트기 감지되었을때 동작한다.
 */
export default function* watchSearch() {
    yield takeEvery(CHANGE_LOGIN, fetchChangeLogin);
    yield takeEvery(CHANGE_INFO, fetchChangeUserInfo);
}