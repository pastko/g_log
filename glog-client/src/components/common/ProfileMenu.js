import { Menu, MenuItem, ListItemIcon, Divider } from '@mui/material';
import NoteAltOutlinedIcon from '@mui/icons-material/NoteAltOutlined';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import LogoutIcon from '@mui/icons-material/Logout';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from "react-redux";
import { actionCreators as userActions } from '../../store/reducer/users';

function ProfileMenu({ anchorEl, open, handleClose }) {
    const dispatch = useDispatch();
    const isLogin = useSelector((state) => state.user.is_login);
    const goLogout = () => {

        if (isLogin) {
            console.log("sign In");
            dispatch(userActions.SignOut());
            window.location.href = "/";
        }
    };
    return (
        <Menu
            anchorEl={anchorEl}
            open={open}
            onClose={handleClose}
            onClick={handleClose}
            PaperProps={{
                elevation: 0,
                sx: {
                    overflow: 'visible',
                    filter: 'drop-shadow(0px 2px 8px rgba(0,0,0,0.32))',
                    mt: 1.5,
                    '& .MuiAvatar-root': {
                        width: 34,
                        height: 34,
                        ml: -0.5,
                        mr: 1,
                    },
                    '&:before': {
                        content: '""',
                        display: 'block',
                        position: 'absolute',
                        top: 0,
                        right: 14,
                        width: 10,
                        height: 10,
                        bgcolor: 'background.paper',
                        transform: 'translateY(-50%) rotate(45deg)',
                        zIndex: 0,
                    },
                },
            }}
            transformOrigin={{ horizontal: 'right', vertical: 'top' }}
            anchorOrigin={{ horizontal: 'right', vertical: 'bottom' }}
        >
            <MenuItem>
                <Link to="/profile">
                    <ListItemIcon sx={{ verticalAlign: "top" }}>
                        <AccountCircleIcon fontSize="medium" />
                    </ListItemIcon>
                    Profile
                </Link>
            </MenuItem>
            <Divider />
            <MenuItem>
                <Link to="/post/list">
                    <ListItemIcon sx={{ verticalAlign: "top" }}>
                        <NoteAltOutlinedIcon fontSize="medium" />
                    </ListItemIcon>
                    내 게시글
                </Link>
            </MenuItem>
            <MenuItem onClick={goLogout}>
                <ListItemIcon sx={{ verticalAlign: "top" }} >
                    <LogoutIcon fontSize="medium" />
                </ListItemIcon>
                로그아웃
            </MenuItem>
        </Menu>
    );
}

export default ProfileMenu;
