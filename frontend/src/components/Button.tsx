import Link from 'next/link';
import { text } from 'stream/consumers';

interface ButtonProps {
  label: string;
  href?: string;
  onClick?: () => void;
  className?: string;
  type?: "button" | "submit" | "reset";
  textOnly?: boolean;
  disabled?: boolean;
}

const Button = ({ 
  label, 
  href, 
  onClick, 
  className = "", 
  type = "button",
  textOnly = false,
  disabled = false
}: ButtonProps) => {
  
  const baseStyles = `inline-block bg-blue-600 text-white px-4 py-2 rounded-lg font-medium hover:bg-blue-700 transition-colors text-center cursor-pointer  ${disabled ? 'cursor-pointer opacity-70 text-slate-800 pointer-events-none' : ''} ${className}`;

  if (textOnly) {
    return (
      <span onClick={onClick} className={`text-blue-600 hover:underline cursor-pointer ${disabled ? 'cursor-pointer opacity-70 text-slate-800' : ''} ${className}`}>
        {label}
      </span>
    );
  }

  if (href) {
    return (
      <Link href={href} className={baseStyles}>
        {label}
      </Link>
    );
  }

  return (
    <button type={type} onClick={onClick} className={baseStyles}>
      {label}
    </button>
  );
};

export default Button;