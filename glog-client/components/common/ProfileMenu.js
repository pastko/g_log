/* eslint-disable @next/next/link-passhref */
import { Avatar, Menu, MenuItem, ListItemIcon, Divider } from '@mui/material';
import NoteAltOutlinedIcon from '@mui/icons-material/NoteAltOutlined';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import Link from 'next/link';

function ProfileMenu({ anchorEl, open, handleClose }) {
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
                <Link href="/Profile">
                    <a>
                        <ListItemIcon sx={{verticalAlign: "top"}}>
                            <AccountCircleIcon fontSize="medium" />
                        </ListItemIcon>
                        Profile
                    </a>
                </Link>
            </MenuItem>
            <Divider />
            <MenuItem>
                <Link href="#내 게시글">
                    <a>
                        <ListItemIcon sx={{verticalAlign: "top"}}>
                            <NoteAltOutlinedIcon fontSize="medium" />
                        </ListItemIcon>
                        내 게시글
                    </a>
                </Link>
            </MenuItem>
        </Menu>
    );
}

export default ProfileMenu;
