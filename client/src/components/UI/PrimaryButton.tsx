import React, { FC } from 'react';

interface PrimaryButtonProps {
    children: any;
    type?: 'button' | 'submit';
    value?: string;
    onClick?: any;
}

export const PrimaryButton: FC<PrimaryButtonProps> = ({
    children,
    ...props
}) => {
    return (
        <button
            {...props}
            className={
                'flex items-center justify-center px-6 lg:py-2 py-3 text-sm cursor-pointer rounded text-white bg-blue-600 hover:bg-blue-700 w-full dark:bg-sky-500 dark:text-slate-800 dark:hover:bg-sky-400'
            }
        >
            {children}
        </button>
    );
};
