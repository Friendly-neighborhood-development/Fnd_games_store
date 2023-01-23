import React, {FC} from 'react';

interface SecondaryButtonProps {
    children: any;
    type?: "button" | "submit"
    value?: string
    onClick?: any
}

export const SecondaryButton: FC<SecondaryButtonProps> = ({children, ...props}) => {
    return (
        <button {...props}
                className={"flex items-center justify-center px-6 lg:py-2 py-3 text-sm cursor-pointer rounded capitalize bg-green-500 hover:bg-green-600 w-full text-white dark:bg-green-700 dark:hover:bg-green-600"}>
            {children}
        </button>
    );
}
