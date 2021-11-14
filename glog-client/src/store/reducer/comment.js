import axios from 'axios';

axios.defaults.baseURL = process.env.REACT_APP_SERVER_URL;

//action type
const SET_COMMENT = 'SET_COMMENT';
const ADD_COMMENT = 'ADD_COMMENT';
const REMOVE_COMMENT = 'REMOVE_COMMENT';
const EDIT_COMMENT = "EDIT_COMMENT";

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

export const editComment = (commentIdx, comment) => ({
    type: EDIT_COMMENT,
    commentIdx,
    comment
})

const initialState = {
    comments: []
}

const setCommentAPI = (comment) => {

}

const addCommentAPI = (comment) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.post(``, {
                headers: {
                    'Authorization': '',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    comment
                })
            })
            .then((res) => {
                console.log('addCommentAPI : ', res.data);
                dispatch(addComment(res.data));
            })
    }
}