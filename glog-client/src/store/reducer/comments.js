import axios from 'axios';
import {
    handleActions
} from 'redux-actions';
import {
    produce
} from 'immer';

axios.defaults.baseURL = process.env.REACT_APP_SERVER_URL;

//action type
const SET_COMMENT = 'SET_COMMENT';
const ADD_COMMENT = 'ADD_COMMENT';
const REMOVE_COMMENT = 'REMOVE_COMMENT';
const CHAGNGE_COMMENT = "CHAGNGE_COMMENT";

//init action
export const setComment = (comment) => ({
    type: SET_COMMENT,
    comment
});

export const addComment = (comment) => ({
    type: ADD_COMMENT,
    comment
});

export const removeComnet = (commentIdx) => ({
    type: REMOVE_COMMENT,
    commentIdx
});

export const changeComment = (commentIdx, comment) => ({
    type: CHAGNGE_COMMENT,
    commentIdx,
    comment
})

const initialState = {
    comments: []
}

const setCommentAPI = (postId) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(``).then((res) => {
            console.log('setCommentAPI :: ', res.data);
            dispatch(setComment(res.data));
        });
    };
};

const addCommentAPI = (data) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.post(``, {
                headers: {
                    'Authorization': '',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    data
                })
            })
            .then((res) => {
                console.log('addCommentAPI : ', res.data);
                dispatch(addComment(res.data));
            })
            .catch((e) => {
                console.log(e);
                alert('게시글을 등록하지 못했습니다.')
            });
    };
};

const changeCommentAPI = (useId, commentIdx, comment) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(`${commentIdx}`, comment)
            .then((res) => {
                console.log('changeCommentAPI : ', res.data);
                dispatch(changeComment(res.data));
            })
            .catch((e) => {
                console.log(e);
                alert('게시글을 수정하지 못했습니다.');
            });
    };
};

const removeCommentAPI = (userId, commentIdx) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.post(``, {
                headers: {
                    'Authorization': '',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    commentIdx
                })
            })
            .then((res) => {
                console.log('removePost :: ', res.data);
                history.push('/')
            })
            .catch((e) => {
                console.log(e);
                alert('게시글을 삭제하지 못했습니다.')
            });
    };
};

//reducer
export default handleActions({
        [SET_COMMENT]: (state, action) =>
            produce(state, (draft) => {
                console.log('set comment :: ', action);
                draft.comments = action.payload.comments;
            }),
        [ADD_COMMENT]: (state, action) =>
            produce(state, (draft) => {
                draft.comments.unshift(action.payload.comment);
            }),
        [REMOVE_COMMENT]: (state, action) =>
            produce(state, (draft) => {
                const idx = action.payload.commentIdx;
                draft.comments = draft.comments.filter((com) => {
                    console.log('remove comment:: ', com);
                    return com.idx !== idx;
                });
            }),
        [CHAGNGE_COMMENT]: (state, action) =>
            produce(state, (draft) => {
                let idx = draft.comments.findIndex(
                    (com) => com.id === action.payload.commentIdx
                );
                draft.comments[idx] = {
                    ...action.payload.comment
                };
            })
    },
    initialState
)
const actionCreators = {
    setCommentAPI,
    addCommentAPI,
    removeCommentAPI,
    changeCommentAPI
};

export {
    actionCreators
};