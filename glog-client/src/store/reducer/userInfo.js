import {CHANGE_LOGIN , CHANGE_INFO, CHANGE_FAILURE } from '../commandType';


export const initialState = {
    isLogin: false,
    accessToken: '',
    mail: '',
    pwd: '',
    confirmPwd: '',
    nikNm: '',
    error: ''
};

function Reducer(state = initialState, action) {
    // state 의 초깃값을 initialState 로 지정했습니다.
    switch (action.type) {
        case CHANGE_LOGIN:
            return {
                ...state,
                isLogin: action.isLogin,
                accessToken: action.token
            };
        case CHANGE_INFO:
            return {
                ...state,
                mail: action.user.mail,
                pwd: action.user.pwd,
                confirmPwd: action.user.confirmPwd,
                nikNm: action.user.nikNm,
            };
        case CHANGE_FAILURE:
            return {
                ...state,
                error: action.error
            };
        default:
            return state;
    }
}


export default Reducer;