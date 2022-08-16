import React, {FC} from 'react';

interface ButtonProps {
    children: any;
    className?: string
}

const Button: FC<ButtonProps> = ({className, children}) => {
    const rootClasses = "px-6 py-2 text-sm self-center cursor-pointer rounded " + className
    return (
        <button
            className={rootClasses}>
            {children}
        </button>
    );
}

export default Button;