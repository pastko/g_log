import axios from 'axios';

axios.defaults.baseURL = process.env.REACT_APP_SERVER_URL;

console.log('baseURL ::: ', axios.defaults.baseURL);

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

const initialState = {
    posts: [],
    detailPost: [],
}

const setDetailPostAPI = (postIdx) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(`/detail/${postIdx}`).then((res) => {
            console.log('getPost result :: ', res.data);
            dispatch(setDetailPost(res.data));
        })
    }
}

const setDetailPostByIdAPI = () => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(`/detail`, {
            headers: {
                'authorization': sessionStorage.getItem('key'),
                'X-USER-ID': sessionStorage.getItem('mail')
            }
        }).then((res) => {
            console.log('getPostById :: ', res.data);
            dispatch(setDetailPost(res.data));
        })
    }
}

const addPostAPI = (post) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.post(`/write`, {
            headers: {
                'authorization': sessionStorage.getItem('key'),
                'X-USER-ID': sessionStorage.getItem('mail')
            },
            body: JSON.stringify({
                post
            })
        }).then((res) => {
            console.log('addPost :: ', res.data);
            //TODO: message: ok / message: fail
            history.push('/');
        })
    }
}

const changePostAPI = (postIdx, post) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.get(`/write/${postIdx}`, post).then((res) => {
            console.log('changePost :: ', res.data);
            dispatch(setDetailPost(res.data));
        })
    }
}

const removePostAPI = (postIdx) => {
    return (dispatch, getState, {
        history
    }) => {
        axios.post(`/deletepost`, {
            headers: {
                'authorization': sessionStorage.getItem('key'),
                'X-USER-ID': sessionStorage.getItem('mail')
            },
            body: JSON.stringify({
                postIdx
            })
        }).then((res) => {
            console.log('removePost :: ', res.data);
            history.push('/')
        })
    }
}

export default function board(state = initialState, action) {
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

const actionCreator = {
    setDetailPostAPI,
    setDetailPostByIdAPI,
    addPostAPI,
    changePostAPI,
    removePostAPI
}

export {
    actionCreator
};