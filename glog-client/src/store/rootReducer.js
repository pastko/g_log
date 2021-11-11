import { HYDRATE } from 'next-redux-wrapper';
import { combineReducers } from 'redux';
import userinfo from './reducer/userInfo'

function rootReducer(state, action) {
    switch (action.type) {
        case HYDRATE:
            console.log('HYDRATE', action);
            return action.payload;
        default: {
            const combineReducer = combineReducers({
                userinfo
            });
            return combineReducer(state, action);
        }
    }
}

export default rootReducer;