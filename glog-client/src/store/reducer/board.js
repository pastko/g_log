import axios from 'axios';

axios.defaults.baseURL = process.env.REACT_APP_SERVER_URL;

const SET_POST = 'SET_POST';
const SET_DETAIL_POST = 'SET_DETAIL_POST';

export const setPost = (post) => ({
    type: SET_POST,
    post
});

export const setDetailPost = (post) => ({
    type: SET_DETAIL_POST,
    post
});

const initialStae = {
    posts: [],
    detailPost: [],
}

const getPost = (postIdx) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(`/detail/${postIdx}`).then((res) => {
            console.log('getPost result :: ', res.data);
            dispatch(setDetailPost(res.data));
        })
    }
}

const getPostById = (userId) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(`/detail/${userId}`).then((res) => {
            console.log('getPostById :: ', res.data);
            dispatch(setDetailPost(res.data));
        })
    }
}

const addPost = (post) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.post(`/write`, post).then((res) => {
            console.log('addPost :: ', res.data);
            history.push('/');
        })
    }
}

const changePost = (postIdx, post) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(`/write/${postIdx}`, post).then((res) => {
            console.log('changePost :: ', res.data);
            dispatch(setDetailPost(res.data));
        })
    }
}

const removePost = (postIdx) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.post(`/deletepost`, postIdx).then((res) => {
            console.log('removePost :: ', res.data);
            history.push('/')
        })
    }
}

export default function board(state = initialStae, action) {
    switch (action.type) {
        case SET_POST:
            return {
                ...state,
                posts: action.posts
            };
        case SET_DETAIL_POST:
            return {
                ...state,
                detailPost: action.detailPost
            };
        default:
            return state;
    }
}

const actionCreate = {
    setDetailPost,
    setPost,
    getPost,
    getPostById,
    addPost,
    changePost,
    removePost
}

export {
    actionCreate
};