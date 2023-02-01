import { FC } from 'react';

interface DisabledButtonProps {
    children: string;
}

export const DisabledButton: FC<DisabledButtonProps> = ({ children }) => {
    return (
        <button className="flex items-center justify-center px-6 lg:py-2 py-3 text-sm cursor-default rounded text-gray-400 bg-gray-300/50 w-full dark:bg-slate-500/30 dark:text-slate-400">
            {children}
        </button>
    );
};
