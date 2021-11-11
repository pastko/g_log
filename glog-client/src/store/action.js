import {CHANGE_LOGIN , CHANGE_INFO, CHANGE_FAILURE  } from './commandType';

export const changelogin = token => ({
    type: CHANGE_LOGIN,
    isLogin,
    token
});

export const changeinfo = user => ({
    type: CHANGE_INFO,
    user
});

export const changeerror = user => ({
    type: CHANGE_FAILURE,
    error
});