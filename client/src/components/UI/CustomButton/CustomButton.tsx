import React, {FC} from 'react';
import cl from './CustomButton.module.css'

interface CustomButtonProps{
    children: any;
}

const CustomButton:FC<CustomButtonProps> = ({ children}) => {
    return (
        <button className={cl.btn}>
            {children}
        </button>
    );
}

export default CustomButton;